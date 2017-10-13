import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { JobMySuffix } from './job-my-suffix.model';
import { JobMySuffixPopupService } from './job-my-suffix-popup.service';
import { JobMySuffixService } from './job-my-suffix.service';
import { TaskMySuffix, TaskMySuffixService } from '../task';
import { EmployeeMySuffix, EmployeeMySuffixService } from '../employee';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-job-my-suffix-dialog',
    templateUrl: './job-my-suffix-dialog.component.html'
})
export class JobMySuffixDialogComponent implements OnInit {

    job: JobMySuffix;
    isSaving: boolean;

    tasks: TaskMySuffix[];

    employees: EmployeeMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private jobService: JobMySuffixService,
        private taskService: TaskMySuffixService,
        private employeeService: EmployeeMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.taskService.query()
            .subscribe((res: ResponseWrapper) => { this.tasks = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.employeeService.query()
            .subscribe((res: ResponseWrapper) => { this.employees = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.job.id !== undefined) {
            this.subscribeToSaveResponse(
                this.jobService.update(this.job));
        } else {
            this.subscribeToSaveResponse(
                this.jobService.create(this.job));
        }
    }

    private subscribeToSaveResponse(result: Observable<JobMySuffix>) {
        result.subscribe((res: JobMySuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError());
    }

    private onSaveSuccess(result: JobMySuffix) {
        this.eventManager.broadcast({ name: 'jobListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackTaskById(index: number, item: TaskMySuffix) {
        return item.id;
    }

    trackEmployeeById(index: number, item: EmployeeMySuffix) {
        return item.id;
    }

    getSelected(selectedVals: Array<any>, option: any) {
        if (selectedVals) {
            for (let i = 0; i < selectedVals.length; i++) {
                if (option.id === selectedVals[i].id) {
                    return selectedVals[i];
                }
            }
        }
        return option;
    }
}

@Component({
    selector: 'jhi-job-my-suffix-popup',
    template: ''
})
export class JobMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private jobPopupService: JobMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.jobPopupService
                    .open(JobMySuffixDialogComponent as Component, params['id']);
            } else {
                this.jobPopupService
                    .open(JobMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}

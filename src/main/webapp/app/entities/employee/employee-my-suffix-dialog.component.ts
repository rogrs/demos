import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { EmployeeMySuffix } from './employee-my-suffix.model';
import { EmployeeMySuffixPopupService } from './employee-my-suffix-popup.service';
import { EmployeeMySuffixService } from './employee-my-suffix.service';
import { DepartmentMySuffix, DepartmentMySuffixService } from '../department';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-employee-my-suffix-dialog',
    templateUrl: './employee-my-suffix-dialog.component.html'
})
export class EmployeeMySuffixDialogComponent implements OnInit {

    employee: EmployeeMySuffix;
    isSaving: boolean;

    employees: EmployeeMySuffix[];

    departments: DepartmentMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private employeeService: EmployeeMySuffixService,
        private departmentService: DepartmentMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.employeeService.query()
            .subscribe((res: ResponseWrapper) => { this.employees = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.departmentService.query()
            .subscribe((res: ResponseWrapper) => { this.departments = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.employee.id !== undefined) {
            this.subscribeToSaveResponse(
                this.employeeService.update(this.employee));
        } else {
            this.subscribeToSaveResponse(
                this.employeeService.create(this.employee));
        }
    }

    private subscribeToSaveResponse(result: Observable<EmployeeMySuffix>) {
        result.subscribe((res: EmployeeMySuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError());
    }

    private onSaveSuccess(result: EmployeeMySuffix) {
        this.eventManager.broadcast({ name: 'employeeListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackEmployeeById(index: number, item: EmployeeMySuffix) {
        return item.id;
    }

    trackDepartmentById(index: number, item: DepartmentMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-employee-my-suffix-popup',
    template: ''
})
export class EmployeeMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private employeePopupService: EmployeeMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.employeePopupService
                    .open(EmployeeMySuffixDialogComponent as Component, params['id']);
            } else {
                this.employeePopupService
                    .open(EmployeeMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}

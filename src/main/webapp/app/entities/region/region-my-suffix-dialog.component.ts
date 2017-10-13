import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RegionMySuffix } from './region-my-suffix.model';
import { RegionMySuffixPopupService } from './region-my-suffix-popup.service';
import { RegionMySuffixService } from './region-my-suffix.service';
import { CountryMySuffix, CountryMySuffixService } from '../country';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-region-my-suffix-dialog',
    templateUrl: './region-my-suffix-dialog.component.html'
})
export class RegionMySuffixDialogComponent implements OnInit {

    region: RegionMySuffix;
    isSaving: boolean;

    countries: CountryMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private regionService: RegionMySuffixService,
        private countryService: CountryMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.countryService.query()
            .subscribe((res: ResponseWrapper) => { this.countries = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.region.id !== undefined) {
            this.subscribeToSaveResponse(
                this.regionService.update(this.region));
        } else {
            this.subscribeToSaveResponse(
                this.regionService.create(this.region));
        }
    }

    private subscribeToSaveResponse(result: Observable<RegionMySuffix>) {
        result.subscribe((res: RegionMySuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError());
    }

    private onSaveSuccess(result: RegionMySuffix) {
        this.eventManager.broadcast({ name: 'regionListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackCountryById(index: number, item: CountryMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-region-my-suffix-popup',
    template: ''
})
export class RegionMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private regionPopupService: RegionMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.regionPopupService
                    .open(RegionMySuffixDialogComponent as Component, params['id']);
            } else {
                this.regionPopupService
                    .open(RegionMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}

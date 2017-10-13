import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DemoSharedModule } from '../../shared';
import {
    JobHistoryMySuffixService,
    JobHistoryMySuffixPopupService,
    JobHistoryMySuffixComponent,
    JobHistoryMySuffixDetailComponent,
    JobHistoryMySuffixDialogComponent,
    JobHistoryMySuffixPopupComponent,
    JobHistoryMySuffixDeletePopupComponent,
    JobHistoryMySuffixDeleteDialogComponent,
    jobHistoryRoute,
    jobHistoryPopupRoute,
} from './';

const ENTITY_STATES = [
    ...jobHistoryRoute,
    ...jobHistoryPopupRoute,
];

@NgModule({
    imports: [
        DemoSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        JobHistoryMySuffixComponent,
        JobHistoryMySuffixDetailComponent,
        JobHistoryMySuffixDialogComponent,
        JobHistoryMySuffixDeleteDialogComponent,
        JobHistoryMySuffixPopupComponent,
        JobHistoryMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        JobHistoryMySuffixComponent,
        JobHistoryMySuffixDialogComponent,
        JobHistoryMySuffixPopupComponent,
        JobHistoryMySuffixDeleteDialogComponent,
        JobHistoryMySuffixDeletePopupComponent,
    ],
    providers: [
        JobHistoryMySuffixService,
        JobHistoryMySuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemoJobHistoryMySuffixModule {}

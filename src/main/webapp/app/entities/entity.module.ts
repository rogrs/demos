import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { DemoRegionMySuffixModule } from './region/region-my-suffix.module';
import { DemoCountryMySuffixModule } from './country/country-my-suffix.module';
import { DemoLocationMySuffixModule } from './location/location-my-suffix.module';
import { DemoDepartmentMySuffixModule } from './department/department-my-suffix.module';
import { DemoTaskMySuffixModule } from './task/task-my-suffix.module';
import { DemoEmployeeMySuffixModule } from './employee/employee-my-suffix.module';
import { DemoJobMySuffixModule } from './job/job-my-suffix.module';
import { DemoJobHistoryMySuffixModule } from './job-history/job-history-my-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        DemoRegionMySuffixModule,
        DemoCountryMySuffixModule,
        DemoLocationMySuffixModule,
        DemoDepartmentMySuffixModule,
        DemoTaskMySuffixModule,
        DemoEmployeeMySuffixModule,
        DemoJobMySuffixModule,
        DemoJobHistoryMySuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DemoEntityModule {}

import { BaseEntity } from './../../shared';

export class JobMySuffix implements BaseEntity {
    constructor(
        public id?: number,
        public jobTitle?: string,
        public minSalary?: number,
        public maxSalary?: number,
        public tasks?: BaseEntity[],
        public employeeId?: number,
    ) {
    }
}

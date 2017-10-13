import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { EmployeeMySuffix } from './employee-my-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class EmployeeMySuffixService {

    private resourceUrl = SERVER_API_URL + 'api/employees';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/employees';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(employee: EmployeeMySuffix): Observable<EmployeeMySuffix> {
        const copy = this.convert(employee);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    update(employee: EmployeeMySuffix): Observable<EmployeeMySuffix> {
        const copy = this.convert(employee);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    find(id: number): Observable<EmployeeMySuffix> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    search(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceSearchUrl, options)
            .map((res: any) => this.convertResponse(res));
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        const result = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            result.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return new ResponseWrapper(res.headers, result, res.status);
    }

    /**
     * Convert a returned JSON object to EmployeeMySuffix.
     */
    private convertItemFromServer(json: any): EmployeeMySuffix {
        const entity: EmployeeMySuffix = Object.assign(new EmployeeMySuffix(), json);
        entity.hireDate = this.dateUtils
            .convertDateTimeFromServer(json.hireDate);
        return entity;
    }

    /**
     * Convert a EmployeeMySuffix to a JSON which can be sent to the server.
     */
    private convert(employee: EmployeeMySuffix): EmployeeMySuffix {
        const copy: EmployeeMySuffix = Object.assign({}, employee);

        copy.hireDate = this.dateUtils.toDate(employee.hireDate);
        return copy;
    }
}

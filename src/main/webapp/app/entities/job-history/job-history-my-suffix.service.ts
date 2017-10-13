import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { JobHistoryMySuffix } from './job-history-my-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class JobHistoryMySuffixService {

    private resourceUrl = SERVER_API_URL + 'api/job-histories';
    private resourceSearchUrl = SERVER_API_URL + 'api/_search/job-histories';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(jobHistory: JobHistoryMySuffix): Observable<JobHistoryMySuffix> {
        const copy = this.convert(jobHistory);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    update(jobHistory: JobHistoryMySuffix): Observable<JobHistoryMySuffix> {
        const copy = this.convert(jobHistory);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    find(id: number): Observable<JobHistoryMySuffix> {
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
     * Convert a returned JSON object to JobHistoryMySuffix.
     */
    private convertItemFromServer(json: any): JobHistoryMySuffix {
        const entity: JobHistoryMySuffix = Object.assign(new JobHistoryMySuffix(), json);
        entity.startDate = this.dateUtils
            .convertDateTimeFromServer(json.startDate);
        entity.endDate = this.dateUtils
            .convertDateTimeFromServer(json.endDate);
        return entity;
    }

    /**
     * Convert a JobHistoryMySuffix to a JSON which can be sent to the server.
     */
    private convert(jobHistory: JobHistoryMySuffix): JobHistoryMySuffix {
        const copy: JobHistoryMySuffix = Object.assign({}, jobHistory);

        copy.startDate = this.dateUtils.toDate(jobHistory.startDate);

        copy.endDate = this.dateUtils.toDate(jobHistory.endDate);
        return copy;
    }
}

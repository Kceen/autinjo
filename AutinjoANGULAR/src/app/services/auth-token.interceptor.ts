import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable()
export class AuthTokenInterceptor implements HttpInterceptor {

    constructor(private authService: AuthService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler):
        Observable<HttpEvent<any>> {
            if(this.authService.authToken) {
                const authReq = req.clone({
                    headers: req.headers.set(
                        "Authorization", this.authService.authToken+""
                    )
                });
                req = authReq;
            }
        return next.handle(req);
    }
}





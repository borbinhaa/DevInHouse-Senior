import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanActivateChild {
  statesOfRouter: any;

  constructor(private router: Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    console.log("teste");
    console.log(state);
    console.log(route);


    return route.params['email'] === 'jonas@gmail.com';
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    // this.statesOfRouter = this.router.getCurrentNavigation().extras.state;
    // implemente o resto aqui
    return true;
  }
}

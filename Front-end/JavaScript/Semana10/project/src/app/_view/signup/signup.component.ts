import { ActivatedRoute, ParamMap, ActivatedRouteSnapshot } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  id: string = '';

  // constructor(private actRoute: ActivatedRoute, private route: ActivatedRouteSnapshot) { }

  constructor(private actRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.actRoute.params.subscribe(
      (params) => { this.id = params['id'] }
    );
    console.log(this.id);
    console.log(this.actRoute.snapshot.params['id']);

    // console.log('oi');
    // console.log(this.actRoute.snapshot.params['id']);

  }

}

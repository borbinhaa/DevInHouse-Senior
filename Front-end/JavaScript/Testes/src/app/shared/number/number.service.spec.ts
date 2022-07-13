import { TestBed } from '@angular/core/testing';

import { NumberService } from './number.service';

describe('NumberService', () => {
  let service: NumberService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NumberService);
  });

  it(`#${NumberService.prototype.getNumberOne.name} deve retornar 1`, () => {
    expect(service).toBeTruthy();
    expect(service.getNumberOne()).toBe(1);
  });
});

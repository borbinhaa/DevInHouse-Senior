import { TestBed } from '@angular/core/testing';
import * as moment from 'moment';

import { ExcerciseServiceService } from './excercise-service.service';

describe('ExcerciseServiceService', () => {
  let service: ExcerciseServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExcerciseServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it(`#${ExcerciseServiceService.prototype.isToday.name} deve retornar true quando for o dia atual`, () => {
    expect(service.isToday(new Date())).toBeTruthy();
  })

  it(`#${ExcerciseServiceService.prototype.isToday.name} deve retornar false quando for qualquer outro dia diferente do dia atual`, () => {
    expect(service.isToday(moment().add(25, 'hours').toDate())).toBeFalsy();
  })

  it(`#${ExcerciseServiceService.prototype.isActualMonth.name} deve retornar true quando for o mês atua;`, () => {
    expect(service.isActualMonth(new Date())).toBeTruthy();
  })

  it(`#${ExcerciseServiceService.prototype.isActualMonth.name} deve retornar false quando não for o mês atual`, () => {
    expect(service.isActualMonth(moment().subtract(1, 'month').toDate())).toBeFalsy();
  })

  it(`#${ExcerciseServiceService.prototype.isActualMonth.name} deve retornar false quando for um mês futuro`, () => {
    expect(service.isActualMonth(moment().add(1, 'month').toDate())).toBeFalsy();
  })

  it(`#${ExcerciseServiceService.prototype.isExpired.name} deve retornar [Vencido] quando o valor passar da data atual`, () => {
    expect(service.isExpired(moment().add(25, 'hours').toDate())).toEqual('Vencido');
  })

  it(`#${ExcerciseServiceService.prototype.isExpired.name} deve retornar [Não vencido] quando o valor não passar da data atual`, () => {
    expect(service.isExpired(moment().subtract(25, 'hours').toDate())).toEqual('Não vencido');
  })

  it(`#${ExcerciseServiceService.prototype.isExpired.name} deve retornar [Não vencido] quando o valor for o mesmo dia`, () => {
    expect(service.isExpired(moment().subtract(25, 'hours').toDate())).toEqual('Não vencido');
  })

  it(`#${ExcerciseServiceService.prototype.formata.name} deve retornar a data no formato brasileiro [dd/MM/yyy] quando for uma data correta`, () => {
    expect(service.formata(new Date(2022, 0, 1))).toEqual('01/01/2022')
  })

  it(`#${ExcerciseServiceService.prototype.getDayOfWeek.name} deve retornar a [Domingo] quando for uma data correspondente a domingo`, () => {
    expect(service.getDayOfWeek(new Date(2022, 6, 3))).toEqual('Domingo')
  })

  it(`#${ExcerciseServiceService.prototype.getDayOfWeek.name} deve retornar a [Segunda-Feira] quando for uma data correspondente a segunda-feira`, () => {
    expect(service.getDayOfWeek(new Date(2022, 6, 4))).toEqual('Segunda-Feira')
  })

  it(`#${ExcerciseServiceService.prototype.getDayOfWeek.name} deve retornar a [Terça-Feira] quando for uma data correspondente a terça-feira`, () => {
    expect(service.getDayOfWeek(new Date(2022, 6, 5))).toEqual('Terça-Feira')
  })

  it(`#${ExcerciseServiceService.prototype.getDayOfWeek.name} deve retornar a [Quarta-Feira] quando for uma data correspondente a quarta-feira`, () => {
    expect(service.getDayOfWeek(new Date(2022, 6, 6))).toEqual('Quarta-Feira')
  })

  it(`#${ExcerciseServiceService.prototype.getDayOfWeek.name} deve retornar a [Quinta-Feira] quando for uma data correspondente a quinta-feira`, () => {
    expect(service.getDayOfWeek(new Date(2022, 6, 7))).toEqual('Quinta-Feira')
  })

  it(`#${ExcerciseServiceService.prototype.getDayOfWeek.name} deve retornar a [Sexta-Feira] quando for uma data correspondente a sexta-feira`, () => {
    expect(service.getDayOfWeek(new Date(2022, 6, 8))).toEqual('Sexta-Feira')
  })

  it(`#${ExcerciseServiceService.prototype.getDayOfWeek.name} deve retornar a [Sábado] quando for uma data correspondente a sábado`, () => {
    expect(service.getDayOfWeek(new Date(2022, 6, 9))).toEqual('Sábado')
  })

  it(`#${ExcerciseServiceService.prototype.dateIsBetween.name} deve retornar true caso a data esteja entre as outras 2 datas`, () => {
    const actualDate = moment().toDate();
    const nextDay = moment().add(1, 'day').toDate();
    const yesterday = moment().subtract(1, 'day').toDate();
    expect(service.dateIsBetween(yesterday, nextDay, actualDate)).toBeTruthy();
  })


  it(`#${ExcerciseServiceService.prototype.dateIsBetween.name} deve retornar false caso a data seja superior a uma das outras 2 datas`, () => {
    const actualDate = moment().toDate();
    const nextDay = moment().add(1, 'day').toDate();
    const yesterday = moment().subtract(1, 'day').toDate();
    expect(service.dateIsBetween(yesterday, actualDate, nextDay)).toBeFalsy();
  })


  it(`#${ExcerciseServiceService.prototype.dateIsBetween.name} deve retornar false caso a data seja inferior a uma das outras 2 datas`, () => {
    const actualDate = moment().toDate();
    const nextDay = moment().add(1, 'day').toDate();
    const yesterday = moment().subtract(1, 'day').toDate();
    expect(service.dateIsBetween(nextDay, actualDate, yesterday)).toBeFalsy();
  })

  it(`#${ExcerciseServiceService.prototype.schedule.name} deve retornar 1 caso adicione uma data`, () => {
    const now = moment().toDate();
    expect(service.schedule(now)).toEqual(1);
  })

  it(`#${ExcerciseServiceService.prototype.schedule.name} deve retornar 2 caso adicione duas data`, () => {
    const now = moment().toDate();
    const nextDay = moment().add(1, 'day').toDate();

    service.schedule(now);
    expect(service.schedule(nextDay)).toEqual(2);
  })

  it(`#${ExcerciseServiceService.prototype.schedule.name} deve retornar um erro caso adicione uma data existente`, () => {
    const now = moment().toDate();
    service.schedule(now)

    expect(() => service.schedule(now)).toThrow(new Error('Data já está ocupada'));
  })

  it(`#${ExcerciseServiceService.prototype.isScheduled.name} deve retornar true quando a data já estiver agendada`, () => {
    const date = new Date();

    service.schedule(date);
    expect(service.isScheduled(date)).toBeTruthy();
  })

  it(`#${ExcerciseServiceService.prototype.isScheduled.name} deve retornar false quando a data não estiver agendada`, () => {
    expect(service.isScheduled(new Date())).toBeFalsy();
  })

  it(`#${ExcerciseServiceService.prototype.suggestDate.name} deve retornar data de hoje quando hoje não estiver ocupado`, () => {
    expect(service.suggestDate()).toEqual(service.formata(new Date()));
  })

  it(`#${ExcerciseServiceService.prototype.suggestDate.name} deve retornar data de amanhã quando hoje estiver ocupado`, () => {
    const yesterday = moment().subtract(1, 'day').toDate();
    const today = moment().toDate();
    const anotherDate = moment().add(2, 'day').toDate();

    service.schedule(yesterday);
    service.schedule(today);
    service.schedule(anotherDate);

    expect(service.suggestDate()).toEqual(service.formata(moment().add(1, 'day').toDate()));
  })
});

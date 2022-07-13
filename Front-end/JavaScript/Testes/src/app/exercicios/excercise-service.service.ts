import { formatDate } from '@angular/common';
import { Injectable } from '@angular/core';
import * as moment from 'moment';

@Injectable({
  providedIn: 'root'
})
export class ExcerciseServiceService {

  private daysOfWeek: string[] = ['Domingo', 'Segunda-Feira', 'Terça-Feira',
    'Quarta-Feira', 'Quinta-Feira', 'Sexta-Feira', 'Sábado']

  private saveDatas: any[] = []
  private date!: Date;

  constructor() {
  }

  isToday(data: Date): boolean {
    const date = new Date();
    return date.getDate() === data.getDate();
  }

  isActualMonth(data: Date): boolean {
    const date = new Date();
    return date.getMonth() === data.getMonth();
  }

  isExpired(data: Date): string {
    if (moment().isSame(data, 'day')) {
      return 'Não vencido';
    }

    return moment().isBefore(data) ? 'Vencido' : 'Não vencido';
  }

  formata(date: Date): string | null {
    return formatDate(date, 'dd/MM/yyyy', 'en_us');
  }

  getDayOfWeek(date: Date): string {
    return this.daysOfWeek[date.getDay()];
  }

  dateIsBetween(initialDate: Date, finalDate: Date, date: Date): boolean {
    return moment(date).isBetween(initialDate, finalDate);
  }

  schedule(data: Date): number {
    const dataFormatada = this.formata(data);
    if (this.saveDatas.includes(dataFormatada)) {
      throw new Error('Data já está ocupada');
    }

    this.saveDatas.push(dataFormatada);
    return this.saveDatas.length;
  }

  isScheduled(data: Date): boolean {
    return this.saveDatas.includes(this.formata(data));
  }

  suggestDate(): any {
    this.date = new Date();

    while (true) {
      const dataFormatada = this.formata(this.date);

      if (!this.saveDatas.includes(dataFormatada)) {
        return dataFormatada;
      }
      this.date = moment(this.date).add(1, 'day').toDate();
    }
  }
}

import { Injectable } from '@angular/core';
import { RegisterModel } from '../../models/register.model';

@Injectable()
export abstract class IRegisterService {
  constructor() {}

  abstract register(value: RegisterModel): void;
}

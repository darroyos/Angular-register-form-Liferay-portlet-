import { Injectable } from '@angular/core';
import { RegisterModel } from '../../models/register.model';
import { IRegisterService } from './register.service';

@Injectable()
export class RegisterPersistentService implements IRegisterService {
  register(value: RegisterModel): void {
    throw new Error('Method not implemented.');
  }
}
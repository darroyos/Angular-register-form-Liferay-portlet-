import { Injectable } from '@angular/core';
import { RegisterModel } from '../../models/register.model';
import { IRegisterService } from './register.service';

@Injectable()
export class RegisterPersistentService implements IRegisterService {
  register(user: RegisterModel): boolean {
    throw new Error('Method not implemented.');
  }
}

import { Injectable } from '@angular/core';
import { RegisterModel } from '../../models/register.model';
import { ApiService } from '../api.service';
import { IRegisterService } from './register.service';

@Injectable()
export class RegisterPersistentService implements IRegisterService {
  constructor(private apiService: ApiService) {}

  register(user: RegisterModel): Promise<RegisterModel> {
    return this.apiService.post('registerForm', user).toPromise();
  }
}

import { CommonModule } from '@angular/common';
import { NgModule, Optional, SkipSelf } from '@angular/core';
import { throwIfAlreadyLoaded } from './guards/module-import.guard';
import { ApiService } from './services/api.service';
import { RegisterLocalStorageService } from './services/register/register-localstorage.service';
import { RegisterPersistentService } from './services/register/register-persistent.service';
import { IRegisterService } from './services/register/register.service';

@NgModule({
  imports: [CommonModule],
  providers: [
    ApiService,
    { provide: IRegisterService, useClass: RegisterPersistentService },
  ],
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    throwIfAlreadyLoaded(parentModule, 'CoreModule');
  }
}

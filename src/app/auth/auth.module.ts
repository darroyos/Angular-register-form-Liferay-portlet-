import { NgModule } from '@angular/core';

import { AuthComponent } from './auth.component';
import { AuthRoutingModule } from './auth-routing.module';
import { SharedModule } from '../shared/shared.module';

import {
  RecaptchaFormsModule,
  RecaptchaModule,
  RecaptchaSettings,
  RECAPTCHA_SETTINGS,
} from 'ng-recaptcha';
import { environment } from 'src/environments/environment';
import { IRegisterService } from '../core/services/register/register.service';
import { RegisterLocalStorageService } from '../core/services/register/register-localstorage.service';

const globalSettings: RecaptchaSettings = {
  siteKey: environment.recaptchaSiteKey,
};

@NgModule({
  imports: [
    AuthRoutingModule,
    SharedModule,
    RecaptchaModule,
    RecaptchaFormsModule,
  ],
  declarations: [AuthComponent],
  providers: [
    { provide: IRegisterService, useClass: RegisterLocalStorageService },
    {
      provide: RECAPTCHA_SETTINGS,
      useValue: globalSettings,
    },
  ],
})
export class AuthModule {}

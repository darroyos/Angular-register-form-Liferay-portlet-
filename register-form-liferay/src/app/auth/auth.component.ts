import { Component } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { NotificationService } from '../core/services/notification.service';
import { IRegisterService } from '../core/services/register/register.service';

@Component({
  selector: 'app-auth-page',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent {
  registerForm: FormGroup;

  private errorMessages = {
    name: 'Debe introducir el nombre',
    surname: 'Debe introducir el apellido',
    birthDate: 'Debe introducir una fecha de nacimiento válida',
    email: 'Debe introducir un correo electrónico válido',
    recaptcha: 'Debe completar el CAPTCHA',
  };

  constructor(
    private _fb: FormBuilder,
    private _notificationService: NotificationService,
    private _registerService: IRegisterService
  ) {
    this.registerForm = this._fb.group({
      name: [null, Validators.required],
      surname: [null, Validators.required],
      birthDate: [null, [Validators.required, this.dateValidator]],
      email: [null, [Validators.required, Validators.email]],
      recaptcha: [null, Validators.required],
    });
  }

  submit(): void {
    if (this.registerForm.valid) {
      this._registerService.register(this.registerForm.value).then((user) => {
        if (user) {
          this._notificationService.open('✔️ Se ha registrado correctamente');
        } else {
          this._notificationService.open(
            '❌ Ha ocurrido un error durante el registro'
          );
        }
      });
    } else {
      let hasEmptyFields = true;
      for (const control in this.registerForm.controls) {
        const invalidControl =
          this.registerForm.controls[control].invalid &&
          this.registerForm.controls[control].dirty;

        if (invalidControl) {
          this._notificationService.open(`❌ ${this.errorMessages[control]}`);
          hasEmptyFields = false;
        }
      }

      if (hasEmptyFields) {
        this._notificationService.open('❌ Debe completar todos los campos');
      }
    }
  }

  clearForm(): void {
    this.registerForm.reset();
  }

  private dateValidator(c: AbstractControl): { [key: string]: boolean } {
    const value = c.value;
    if (value && typeof value === 'string') {
      const match = value.match(
        /^([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/
      );
      if (!match) {
        return { dateInvalid: true };
      } else if (match && match[0] !== value) {
        return { dateInvalid: true };
      }
    }
    return null;
  }
}

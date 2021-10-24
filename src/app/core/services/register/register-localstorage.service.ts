import { Injectable } from '@angular/core';
import { RegisterModel } from '../../models/register.model';
import { IRegisterService } from './register.service';

const LS_USERS_KEY = 'users';

@Injectable()
export class RegisterLocalStorageService implements IRegisterService {

  /**
   * Add user to the LocalStorage
   * 
   * @param user User to register
   * @returns true if the operation completes successfully, false otherwise
   */
  register(user: RegisterModel): boolean {
    const registerDate = new Date();
    user.registeredOn = registerDate;

    if (!this.isStorageInitialized()) {
      this.initStorage();
    }
    return this.add(user);
  }

  /**
   * Add user to the LocalStorage
   * 
   * @param user User to register
   * @returns true if the operation completes successfully, false otherwise
   */
  private add(user: RegisterModel): boolean {
    try {
      const users: RegisterModel[] = JSON.parse(
        localStorage.getItem(LS_USERS_KEY)
      );
      users.push(user);
      localStorage.setItem(LS_USERS_KEY, JSON.stringify(users));

      return true;
    } catch (e) {
      return false;
    }
  }

  /**
   * Init local storage
   */
  private initStorage(): void {
    localStorage.setItem(LS_USERS_KEY, JSON.stringify([]));
  }

  /**
   * Checks if LocalStorage has been initialized
   * @returns true if initialized, false otherwise
   */
  private isStorageInitialized(): boolean {
    const users = localStorage.getItem(LS_USERS_KEY);
    if (users !== null) {
      try {
        const usersObj = JSON.parse(users);
        return Array.isArray(usersObj);
      } catch (e) {
        return false;
      }
    }
  }
}

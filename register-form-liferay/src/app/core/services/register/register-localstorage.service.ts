import { Injectable } from '@angular/core';
import { RegisterModel } from '../../models/register.model';
import { IRegisterService } from './register.service';
import { v4 as uuid } from 'uuid';

const LS_USERS_KEY = 'users';

@Injectable()
export class RegisterLocalStorageService implements IRegisterService {
  /**
   * Add user to the LocalStorage
   *
   * @param user User to register
   * @returns true if the operation completes successfully, false otherwise
   */
  register(user: RegisterModel): Promise<RegisterModel> {
    const registerDate = new Date();
    user.registeredOn = registerDate;

    if (!this.isStorageInitialized()) {
      this.initStorage();
    }
    return Promise.resolve(this.add(user));
  }

  /**
   * Add user to the LocalStorage
   *
   * @param user User to register
   * @returns true if the operation completes successfully, false otherwise
   */
  private add(user: RegisterModel): RegisterModel {
    const userId = uuid(); // generate a unique ID for the user
    user.id = userId;

    try {
      const users: { [id: string]: RegisterModel } = JSON.parse(
        localStorage.getItem(LS_USERS_KEY)
      );
      users[userId] = user;
      localStorage.setItem(LS_USERS_KEY, JSON.stringify(users));

      return user;
    } catch (e) {
      return null;
    }
  }

  /**
   * Init local storage
   */
  private initStorage(): void {
    localStorage.setItem(LS_USERS_KEY, JSON.stringify({}));
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
        return typeof usersObj === 'object';
      } catch (e) {
        return false;
      }
    }
  }
}

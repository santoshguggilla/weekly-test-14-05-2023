# weekly-test-14-05-2023


# Framework used
Spring boot

# Data flow

## 1. user signUp process</br>
firstly checks the email in database if it present it thows an exception or else continues</br>
secondly it encrypts the password </br>
third step it generates token for user</br>
four step it save the data in database</br>
and finally it shows message successfully signup

## 2. user signIn process</br>
firstly checks the email in database if it not present it throws an exception or else continues </br>
secondly it encrypts the password to verify with database </br>
third step it return token id
and finally it shows message successfully signin

## 3. user update process</br>
it will update the user in given parametes.

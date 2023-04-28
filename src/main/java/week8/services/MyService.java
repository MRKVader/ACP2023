package week8.services;

import week8.dao.GeneraDao;
import week8.exception.MyServiceExcept;
import week8.exception.MyValidationException;
import week8.exception.NoUserFoundExcept;
import week8.model.MyUser;
import week8.validator.GeneralValidator;

public class MyService {

    private GeneraDao genDao;
    private GeneralValidator genValid;

    public String login(String email, String pass) throws MyServiceExcept {
        if(!genValid.isValidEmail(email) || !genValid.isValidPass(pass)){
            throw new MyValidationException("Wrong email or pass");
        }
        MyUser findByEmail = genDao.find(email);
        if(findByEmail == null){
            throw new NoUserFoundExcept("Wrong email or pass");
        }

        if(findByEmail.getPass().equals(pass)){
            return "key";
        }

        throw new NoUserFoundExcept("Wrong email or pass");
    }

    public GeneraDao getGenDao() {
        return genDao;
    }

    public void setGenDao(GeneraDao genDao) {
        this.genDao = genDao;
    }

    public GeneralValidator getGenValid() {
        return genValid;
    }

    public void setGenValid(GeneralValidator genValid) {
        this.genValid = genValid;
    }
}

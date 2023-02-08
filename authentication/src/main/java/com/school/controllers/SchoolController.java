package com.school.controllers;

import com.school.exceptions.ValidationException;
import com.school.models.dao.School;
import com.school.models.dao.Users;
import com.school.repository.SchoolRepository;
import com.school.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api1/")
public class SchoolController {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @RequestMapping( value = "/school/get-schools",  method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {

        log.info("UsersController -> getAllUsers");
        try {
            List<School> schoolList = schoolRepository.findAll();
            return new ResponseEntity(schoolList, HttpStatus.OK);

        } catch (ValidationException vx) {
            vx.printStackTrace();
            log.info("UserController -> getAllUsers -> ValidationException");
//            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
//                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
//                    "propertiesUtil.getApplicationMessages()"), HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            log.info("UserController -> getAllUsers -> Exception -> 91");
//            ex.printStackTrace();
//            return new ResponseEntity(generateGlobalResponse.generateGlobalResponse(
//                    null, "constants.getRESPONSE_INDICATOR_ERROR_0()", "constants.getSUCCESSFULL_RESPONSE_CODE_200()",
//                    "propertiesUtil.getApplicationMessages().getProperty"), HttpStatus.OK);
        }
        return null;
    }
}

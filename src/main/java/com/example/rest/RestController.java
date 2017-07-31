package com.example.rest;

import com.example.entity.Example;
import com.example.service.ExampleService;
import com.example.dto.ExampleDto;
import com.example.dto.MessageDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/**
 * Controller to expose rest methods
 *
 * @author Pablo Carnero Liñán
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/restServices")
@Validated
public class RestController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find by name
     *
     * @param name name to search
     * @return list of coincidence
     */
    @RequestMapping(path = "findByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<ExampleDto>> findByName(@PathVariable("name") String name)
    {
        List<Example> exampleList = exampleService.findByName(name);
        List<ExampleDto> exampleDtoList = modelMapper.map(exampleList, new TypeToken<List<Example>>() {}.getType());
        return new ResponseEntity<>(exampleDtoList, HttpStatus.OK);
    }

    /**
     * Handle for the MethodArgumentNotValidException. It shows the proper error using the local message.properties.
     *
     * @param ex exception
     * @return message
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageDto handleValidationException(MethodArgumentNotValidException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String code = ex.getBindingResult().getFieldError().getDefaultMessage();
        String message = messageSource.getMessage(code, null, locale);
        return new MessageDto(message);
    }
}


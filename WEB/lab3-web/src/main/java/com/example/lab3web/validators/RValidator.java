package com.example.lab3web.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("RValidator")
public class RValidator extends AbstractValidator{
    private final float min = 1;
    private final float max = 4;
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try{
            float r = (float) o;
            if (r < min || r > max) {
                throw new InvalidRangeException();
            }
        } catch (NullPointerException e) {
            throw new ValidatorException(createMessage("R - обязательное поле"));
        } catch (InvalidRangeException e) {
            throw new ValidatorException(createMessage("R должно быть от "+min+" до "+max));
        }
    }
}

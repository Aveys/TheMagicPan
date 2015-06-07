package processing.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nicolas on 07/06/15.
 */
@FacesValidator(value="pwdValidator")
public class PwdValidator implements Validator {
    private static final String PATTERN = "^[A-Za-z]+";
    private Pattern pattern;
    private Matcher matcher;

    public PwdValidator()
    {
        pattern = Pattern.compile(PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        matcher = pattern.matcher(value.toString());
        UIInput uiInputConfirmPassword;
        if(component.getId().equals("confirmPassword"))
        {
            uiInputConfirmPassword = (UIInput) component.getAttributes()
                    .get("firstPassword");
        }else {
            uiInputConfirmPassword = (UIInput) component.getAttributes()
                    .get("confirmPassword");
        }


        String confirmPassword = uiInputConfirmPassword.getSubmittedValue()
                .toString();

        if(!matcher.matches() || !confirmPassword.equals(value.toString()))
        {


            FacesMessage msg = new FacesMessage(component.getId() + " validation failed.", "Please follow the constraint: " + PATTERN);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}


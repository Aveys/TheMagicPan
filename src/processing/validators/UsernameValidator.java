package processing.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nicolas on 07/06/15.
 */

@FacesValidator(value="usernameValidator")
public class UsernameValidator implements Validator {
    private static final String PATTERN = "^[_A-Za-z0-0-@]+";
    private Pattern pattern;
    private Matcher matcher;

    public UsernameValidator()
    {
        pattern = Pattern.compile(PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches())
        {
            FacesMessage msg = new FacesMessage(component.getId() + " validation failed.", "Please follow the constraint: " + PATTERN);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}

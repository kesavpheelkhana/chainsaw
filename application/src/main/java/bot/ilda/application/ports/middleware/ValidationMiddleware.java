package bot.ilda.application.ports.middleware;

import bot.ilda.infra.adapters.async.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import java.util.Set;

//@Component
//@Order(2)
//public class ValidationMiddleware {
//        implements Command.Middleware {

//    private static final Logger logger = LoggerFactory.getLogger(ValidationMiddleware.class);
//    private final Validator validator;
//
//    public ValidationMiddleware(Validator validator) {
//        this.validator = validator;
//    }
//
//    @Override
//    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
//        logger.debug("Validating command: {}", command.getClass().getSimpleName());
//
//        // Perform validation
//        validateCommand(command);
//
//        // Continue to next middleware
//        return next.invoke();
//    }
//
//    private <C extends Command<?>> void validateCommand(C command) {
//        Set<ConstraintViolation<C>> violations = validator.validate(command);
//
//        if (!violations.isEmpty()) {
//            StringBuilder errorMessage = new StringBuilder("Validation failed for command ")
//                    .append(command.getClass().getSimpleName())
//                    .append(": ");
//
//            violations.forEach(violation ->
//                errorMessage.append(violation.getPropertyPath())
//                          .append(" ")
//                          .append(violation.getMessage())
//                          .append("; "));
//
//            logger.error(errorMessage.toString());
//            throw new ValidationException(errorMessage.toString());
//        }
//
//        logger.debug("Validation passed for command: {}", command.getClass().getSimpleName());
//    }
//}
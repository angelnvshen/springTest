package spring.validator;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import spring.validator.model.Company;
import spring.validator.model.Employee;

/**
 * Created by bf50 on 2015/12/3.
 */
public class ValidatorTest {

    @Test
    public void testBeanWrapper(){
        BeanWrapper company = new BeanWrapperImpl(new Company());
        company.setPropertyValue("name", "Farri");
        PropertyValue value = new PropertyValue("desc", "a sportsCar factory ");
        company.setPropertyValue(value);

        BeanWrapper manager = new BeanWrapperImpl(new Employee());
        manager.setPropertyValue("name", "Tome");
        manager.setPropertyValue("salary", 21222.00);
        company.setPropertyValue("managingDirector", manager.getWrappedInstance());

        String companyName = (String) company.getPropertyValue("name");
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(companyName + " , " + salary);
    }
}

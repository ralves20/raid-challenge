import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
public class MessageDTOTest {


    @Test
    public void testOfMessageDtoWithAllValidInfoShouldReturnANewValidInstance() {
        MessageDTO messageDTO = new MessageDTO();
        assertThat(messageDTO, is(notNullValue()));
    }

    @Test
    public void testOfSetMessageWithAnValidMessageShouldReturnTheMessageProperly() {
        var messageDTO = new MessageDTO();
        var messageOnTest = "unit test - MESSAGE DTO";

        messageDTO.setMessage(messageOnTest);

        assertThat(messageDTO.getMessage(), is(equalTo(messageOnTest)));
    }

    @Test
    public void testOfSetTypeWithAValidTypeDefinedShouldReturnTheTypeProperlySetOnMessageDto() {
        var messageDTO = new MessageDTO();
        var typeOfTest = "messageDtoType";

        messageDTO.setType(typeOfTest);

        assertThat(messageDTO.getType(), is(equalTo(typeOfTest)));
    }
}

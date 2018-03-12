package producer.api.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import producer.api.domain.TaskMessage;


@RestController
public class ProducerController {

    private ProducerService producerService;

    public ProducerController() {
        producerService = new ProducerService();
    }

    @CrossOrigin
    @RequestMapping(value = "/publish-task", method = RequestMethod.POST)
    public ResponseEntity publishTask(@RequestBody TaskMessage taskMessage) {

        producerService.publishTask(taskMessage);

        return new ResponseEntity(HttpStatus.OK);
    }
}

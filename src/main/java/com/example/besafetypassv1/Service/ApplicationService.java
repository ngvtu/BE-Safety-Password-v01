package com.example.besafetypassv1.Service;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class ApplicationService {
    private final Logger logger = LogManager.getLogger(ApplicationService.class);


}

package com.nitesh.advance.kafka.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nitesh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody {
    int id;
    String message;
}

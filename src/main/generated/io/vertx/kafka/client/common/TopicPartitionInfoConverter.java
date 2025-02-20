package io.vertx.kafka.client.common;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Converter and mapper for {@link io.vertx.kafka.client.common.TopicPartitionInfo}.
 * NOTE: This class has been automatically generated from the {@link io.vertx.kafka.client.common.TopicPartitionInfo} original class using Vert.x codegen.
 */
public class TopicPartitionInfoConverter {

   static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, TopicPartitionInfo obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "isr":
          if (member.getValue() instanceof JsonArray) {
            java.util.ArrayList<io.vertx.kafka.client.common.Node> list =  new java.util.ArrayList<>();
            ((Iterable<Object>)member.getValue()).forEach( item -> {
              if (item instanceof JsonObject)
                list.add(new io.vertx.kafka.client.common.Node((io.vertx.core.json.JsonObject)item));
            });
            obj.setIsr(list);
          }
          break;
        case "leader":
          if (member.getValue() instanceof JsonObject) {
            obj.setLeader(new io.vertx.kafka.client.common.Node((io.vertx.core.json.JsonObject)member.getValue()));
          }
          break;
        case "partition":
          if (member.getValue() instanceof Number) {
            obj.setPartition(((Number)member.getValue()).intValue());
          }
          break;
        case "replicas":
          if (member.getValue() instanceof JsonArray) {
            java.util.ArrayList<io.vertx.kafka.client.common.Node> list =  new java.util.ArrayList<>();
            ((Iterable<Object>)member.getValue()).forEach( item -> {
              if (item instanceof JsonObject)
                list.add(new io.vertx.kafka.client.common.Node((io.vertx.core.json.JsonObject)item));
            });
            obj.setReplicas(list);
          }
          break;
      }
    }
  }

   static void toJson(TopicPartitionInfo obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

   static void toJson(TopicPartitionInfo obj, java.util.Map<String, Object> json) {
    if (obj.getIsr() != null) {
      JsonArray array = new JsonArray();
      obj.getIsr().forEach(item -> array.add(item.toJson()));
      json.put("isr", array);
    }
    if (obj.getLeader() != null) {
      json.put("leader", obj.getLeader().toJson());
    }
    json.put("partition", obj.getPartition());
    if (obj.getReplicas() != null) {
      JsonArray array = new JsonArray();
      obj.getReplicas().forEach(item -> array.add(item.toJson()));
      json.put("replicas", array);
    }
  }
}

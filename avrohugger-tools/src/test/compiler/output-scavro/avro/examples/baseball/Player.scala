/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package avro.examples.baseball.model

import org.apache.avro.Schema

import org.oedura.scavro.{AvroMetadata, AvroReader, AvroSerializeable}

import avro.examples.baseball.{Nickname => JNickname, Player => JPlayer}

import scala.collection.JavaConverters._

case class Player(number: Int, first_name: org.apache.avro.util.Utf8, last_name: org.apache.avro.util.Utf8, nicknames: Array[Nickname]) extends AvroSerializeable {
  type J = JPlayer
  override def toAvro: JPlayer = {
    new JPlayer(number, first_name, last_name, {
      val array: java.util.List[JNickname] = new java.util.ArrayList[JNickname]
      nicknames foreach { element =>
        array.add(element.toAvro)
      }
      array
    })
  }
}

object Player {
  implicit def reader = new AvroReader[Player] {
    override type J = JPlayer
  }
  implicit val metadata: AvroMetadata[Player, JPlayer] = new AvroMetadata[Player, JPlayer] {
    override val avroClass: Class[JPlayer] = classOf[JPlayer]
    override val schema: Schema = JPlayer.getClassSchema()
    override val fromAvro: (JPlayer) => Player = {
      (j: JPlayer) => Player(j.getNumber, j.getFirstName, j.getLastName, Array((j.getNicknames.asScala: _*)) map { x =>
        Nickname.metadata.fromAvro(x)
      })
    }
  }
}
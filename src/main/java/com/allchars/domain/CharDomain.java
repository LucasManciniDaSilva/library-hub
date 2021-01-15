package com.allchars.domain;

import com.allchars.interfaces.json.Chars;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chars")
public class CharDomain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tx_id_char")
  private Long idChar;

  @Column(name = "tx_name", nullable = false)
  private String charName;

  @Column(name = "tx_origin", nullable = false)
  private String origin;

  @Column(name = "nr_height", nullable = false)
  private Integer height;

  @Column(name = "tx_weapon")
  private String weapon;

  @Column(name = "tx_armor")
  private String armor;

  @Column(name = "tx_personality")
  private String personality;

  @Column(name = "tx_character_importance", nullable = false)
  private String characterImportance;

  public Chars toChars() {
    return Chars.builder()
        .idChar(this.idChar)
        .charName(this.charName)
        .origin(this.origin)
        .height(this.height)
        .weapon(this.weapon)
        .armor(this.armor)
        .personality(this.personality)
        .characterImportance(this.characterImportance)
        .build();
  }
}

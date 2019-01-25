package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.LeafColor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class LeafColorDto {
    private Long id;
    private String value;

    public static LeafColor fromDto(LeafColorDto leafColorDto,LeafColor leafColor) {
        if (leafColor == null) leafColor = new LeafColor();
        if (leafColorDto.getId() != null) leafColor.setId(leafColorDto.getId());
        if (leafColorDto.getValue() != null && !leafColorDto.getValue().equals("")) leafColor.setValue(leafColorDto.getValue());
        return leafColor;
    }
}

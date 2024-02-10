package com.udacity.jwdnd.course1.cloudstorage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotesDto {
    private String noteTitle;
    private String noteDescription;
}


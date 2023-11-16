package com.cricketcrickbuzz.model;
/*
inningsId:1
runs:410
wickets:4
overs:49.6
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Inngs {
    private Integer inningsId;
    private Integer runs;
    private Integer wickets;
    private Integer overs;
}

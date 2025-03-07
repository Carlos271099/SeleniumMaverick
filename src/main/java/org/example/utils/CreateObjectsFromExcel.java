package org.example.utils;

import com.poiji.bind.Poiji;
import org.example.Candidate;

import java.io.File;
import java.util.List;

public class CreateObjectsFromExcel {


    public static List<Candidate> createCandidates(){
        File archive = new File("CandidatesData.xlsx");
        List<Candidate> candidates = Poiji.fromExcel(archive, Candidate.class);

        return candidates;
    }


}

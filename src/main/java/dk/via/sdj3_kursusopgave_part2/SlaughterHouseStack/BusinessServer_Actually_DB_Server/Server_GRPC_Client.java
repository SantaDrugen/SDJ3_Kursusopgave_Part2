package dk.via.sdj3_kursusopgave_part2.SlaughterHouseStack.BusinessServer_Actually_DB_Server;
import dk.via.sdj3_kursusopgave_part2.AnimalCut;
import dk.via.sdj3_kursusopgave_part2.GetAllAnimalCutsRequest;
import dk.via.sdj3_kursusopgave_part2.GetAllAnimalCutsResponse;
import dk.via.sdj3_kursusopgave_part2.SlaughterServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class Server_GRPC_Client extends SlaughterServiceGrpc.SlaughterServiceImplBase {


//    @Override
//    public Collection<AnimalCut> getAllAnimalCuts() {
//        //Test-code
//        System.out.println("Server_GRPC_Client.getAllAnimalCuts() called");
//        ArrayList animalCuts = new ArrayList<AnimalCut>();
//        animalCuts.add(new AnimalCut("111-111"));
//        //Test-code end.
//
//        return animalCuts;
//    }

    public void getAllAnimalCuts (GetAllAnimalCutsRequest request,
                                  StreamObserver<GetAllAnimalCutsResponse> responseObserver)
    {
        //Test-code
        System.out.println("Server_GRPC_Client.getAllAnimalCuts() called");
        ArrayList<AnimalCut> animalCuts = new ArrayList<>();
        animalCuts.add(AnimalCut.newBuilder().setCutId("111-111").build());
        //Test-code end.

        GetAllAnimalCutsResponse response = GetAllAnimalCutsResponse
                .newBuilder()
                .addAllAnimalCuts(animalCuts)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
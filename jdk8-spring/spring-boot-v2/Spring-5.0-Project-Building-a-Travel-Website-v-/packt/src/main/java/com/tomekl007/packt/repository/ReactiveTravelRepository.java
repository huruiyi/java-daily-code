package com.tomekl007.packt.repository;


import com.tomekl007.packt.model.TravelDto;
import com.tomekl007.packt.model.Travel;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class ReactiveTravelRepository {

  private final TravelRepository travelRepository;

  @Autowired
  public ReactiveTravelRepository(TravelRepository travelRepository) {

    this.travelRepository = travelRepository;
  }

  public Mono<List<TravelDto>> getTravels(String userId) {
    return Mono.defer(() -> Mono.just(travelRepository.findByUserId(userId)))
        .subscribeOn(Schedulers.elastic())
        .map(p ->
            p.stream().map(p1 -> new TravelDto(p1.getUserId(), p1.getSource(), p1.getDestination()))
                .collect(Collectors.toList()));
  }

  public Mono<TravelDto> addTravel(final TravelDto travel) {
    return Mono.just(travel)
        .map(t -> new Travel(t.getUserId(), t.getSource(), t.getDestination()))
        .publishOn(Schedulers.parallel())
        .doOnNext(travelRepository::save)
        .map(t -> new TravelDto(t.getUserId(), t.getSource(), t.getDestination()));
  }
}

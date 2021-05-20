package net.hurelhuyag.demobench.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class DemoData {

    private static final Random random = new SecureRandom();

    public static final PetState PET_STATE = new PetState(
            UUID.randomUUID().toString(),
            new Name(UUID.randomUUID().toString()),
            random.nextLong(),
            random.nextLong(),
            new Kind(UUID.randomUUID().toString()),
            new Owner(UUID.randomUUID().toString())
    );

    public static final List<PetState> PET_STATES = new ArrayList<>();

    static {
        IntStream.iterate(1, operand -> operand + 1)
                .limit(100)
                .forEach(value -> {
                    PET_STATES.add(generate());
                });
    }

    private static PetState generate() {
        return new PetState(
                UUID.randomUUID().toString(),
                new Name(UUID.randomUUID().toString()),
                random.nextLong(),
                random.nextLong(),
                new Kind(UUID.randomUUID().toString()),
                new Owner(UUID.randomUUID().toString())
        );
    }
}

package net.hurelhuyag.demobench.models;

public final class PetState {

  public final String id;
  public final Name name;
  public final long birth;
  public final long death;
  public final Kind kind;
  public final Owner owner;

  public PetState(final String id, final Name name, final long birth, final long death, final Kind kind, final Owner owner) {
    this.id = id;
    this.name = name;
    this.birth = birth;
    this.death = death;
    this.kind = kind;
    this.owner = owner;
  }
}

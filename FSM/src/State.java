/**
 * state0 - не прочитано
 * stateA - прочитан а в (abc) ожидаем b
 * stateB - прочитан b в (abc) ожидаем c
 * stateD - обязательный d прочитан
 * stateE - прочитан e в (ef) ожидаем f
 * stateFinal - конец
 */

public enum State {
    state0, stateA, stateB, stateD, stateE, stateFinal
}

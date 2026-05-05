public class SimpleCPU {
    int[] memory = new int[256]; // ????? ?????
    int accumulator = 20; // ?????? ???????
    int programCounter = 2; // ???? ????????

    public void loadProgram(int[] program) {
        System.arraycopy(program, 0, memory, 0, program.length);
    }

    public void run() {
        while (true) {
            int instruction = memory[programCounter++];
            switch (instruction) {
                case 0: // HALT
                    return;
                case 1: // LOAD
                    accumulator = memory[programCounter++];
                    break;
                case 2: // ADD
                    accumulator += memory[programCounter++];
                    break;
                case 3: // STORE
                    memory[programCounter++] = accumulator;
                    break;
                default:
                    throw new IllegalStateException("عليمة غير معروفة: : " + instruction);
            }
        }
    }

    public static void main(String[] args) {
        SimpleCPU cpu = new SimpleCPU();
        int[] program = {
            1, 10, // LOAD 10
            2, 20, // ADD 20
            3, 100, // STORE ?? ?????? 100
            0 // HALT
        };
        cpu.loadProgram(program);
        cpu.run();
        System.out.println("لنتيجة المخزنة في الموقع 100: " + cpu.memory[100]);
    }
}

import screeps.Game

fun main() {
    val cpu = Game.cpu
    print("limit: ${cpu.limit}")
    print("tickLimit: ${cpu.tickLimit}")
    print("bucket: ${cpu.bucket}")
}

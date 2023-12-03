namespace AoC2023.AoC202302;

public static class Solver
{


    public static int SolveTask1(IEnumerable<string> data)
    {
        const int RedCubes = 12;
        const int GreenCubes = 13;
        const int BlueCubes = 14;
        var sum = 0;
        foreach (var game in data)
        {
            var possibleGame = false;
            var gameInfo = int.Parse(game.Split(":")[0].Split(" ")[1]);
            var sets = game.Split(":")[1].Split(";");
            var colorWithinSets = sets.Select(color => color.Split(",").Select(s => s.Trim().Split(" "))).ToList();
            foreach (var setList in colorWithinSets.Select(set => set.ToList()))
            {
                var redCubes = setList.Where(str => str[1].Equals("red")).Select(str => str[0]).Sum(int.Parse);
                var greenCubes = setList.Where(str => str[1].Equals("green")).Select(str => str[0]).Sum(int.Parse);
                var blueCubes = setList.Where(str => str[1].Equals("blue")).Select(str => str[0]).Sum(int.Parse);

                if (redCubes <= RedCubes && greenCubes <= GreenCubes && blueCubes <= BlueCubes)
                {
                    possibleGame = true;
                }
                else
                {
                    possibleGame = false;
                    break;
                }
            }

            if (possibleGame)
                sum += gameInfo;
        }

        return sum;
    }

    public static int SolveTask2(IEnumerable<string> data)
    {
        var powerOfGames = 0;
        foreach (var game in data)
        {
            var sets = game.Split(":")[1].Split(";");
            var colorWithinSets = sets.Select(color => color.Split(",").Select(s => s.Trim().Split(" "))).ToList();
            var redCubes = 0;
            var greenCubes = 0;
            var blueCubes = 0;
            foreach (var setList in colorWithinSets.Select(set => set.ToList()))
            {
                redCubes = Math.Max(setList.Where(str => str[1].Equals("red")).Select(str => str[0]).Sum(int.Parse), redCubes);
                greenCubes = Math.Max(setList.Where(str => str[1].Equals("green")).Select(str => str[0]).Sum(int.Parse), greenCubes);
                blueCubes = Math.Max(setList.Where(str => str[1].Equals("blue")).Select(str => str[0]).Sum(int.Parse), blueCubes);
            }
            powerOfGames += redCubes * greenCubes * blueCubes;
        }
        return powerOfGames;
    }
}
using System.Text.RegularExpressions;

namespace AoC2023.AoC202304;

public static class Solver
{


    public static double SolveTask1(IEnumerable<string> dataEnumerable)
    {
        var sum = 0d;
        foreach (var card in dataEnumerable)
        {
            var splitNumbers = card.Split(":")[1].Split("|");
            splitNumbers[0] = Regex.Replace(splitNumbers[0].Trim(), @"\s+", " ");
            splitNumbers[1] = Regex.Replace(splitNumbers[1].Trim(), @"\s+", " ");
            var winningNumbers = splitNumbers[0].Trim().Split(" ").ToHashSet();
            var ownNumbers = splitNumbers[1].Trim().Split(" ").ToHashSet();
            var matches = ownNumbers.Count(number => winningNumbers.Contains(number))-1;
            if (matches < 0) continue;
            sum += Math.Pow(2, matches);
        }
        return sum;
    }

    public static double SolveTask2(IEnumerable<string> dataEnumerable)
    {
        var data = dataEnumerable.ToArray();
        var numberOfCards = new int[data.Length];  
        for (var i = 0; i < data.Length; i++)
        {
            var card = data[i];
            var splitNumbers = card.Split(":")[1].Split("|");
            splitNumbers[0] = Regex.Replace(splitNumbers[0].Trim(), @"\s+", " ");
            splitNumbers[1] = Regex.Replace(splitNumbers[1].Trim(), @"\s+", " ");
            var winningNumbers = splitNumbers[0].Trim().Split(" ").ToHashSet();
            var ownNumbers = splitNumbers[1].Trim().Split(" ").ToHashSet();
            var matches = ownNumbers.Count(number => winningNumbers.Contains(number));
            for(var j = 0 ; j <= numberOfCards[i]; j++)
            {
                for (var k = i + 1; k < i + matches + 1; k++)
                {
                    numberOfCards[k]++;
                }
            }
        }
        return numberOfCards.Sum() + numberOfCards.Length;
    }
}
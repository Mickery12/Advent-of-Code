using System.Diagnostics.CodeAnalysis;
using System.IO.Enumeration;
using System.Runtime.CompilerServices;
using System.Text.RegularExpressions;

namespace AoC2023.AoC202303;

public static class Solver
{


    public static int SolveTask1(IEnumerable<string> dataEnumerable)
    {
        var data = dataEnumerable.ToArray();
        var sum = 0;
        var field = new string[data.Length][];
        for (var i = 0; i < data.Length; i++)
        {
            field[i] = new string[data[i].Length];
            var j = 0;
            foreach (var chr in data[i])
            {
                
                field[i][j] = chr.ToString();
                j++;
            }

        }

        for (var i = 0; i < field.Length; i++)
        {
            var rowNumbers = NumbersInRow(data[i]);
            for (var j = 0; j < field[i].Length; j++)
            {
                if (rowNumbers.Count is 0) break;
                if (i == 0)
                {
                    if (!int.TryParse(field[i][j], out var tmp))
                        continue;
                    if (j == 0)
                    {
                        if ((field[i + 1][j] == "." || int.TryParse(field[i + 1][j + 1], out tmp))
                            && (field[i + 1][j + 1] == "." || int.TryParse(field[i + 1][j], out tmp))
                            && (field[i][j + 1] == "." || int.TryParse(field[i][j + 1], out tmp))) continue;
                        sum += rowNumbers
                            .Select(tuple => tuple.Item1).Sum();
                        rowNumbers.Remove(rowNumbers[0]);
                    }
                    else if (j == field[i].Length - 1)
                    {
                        if ((field[i + 1][j] == "." || int.TryParse(field[i + 1][j], out tmp))
                            && (field[i + 1][j - 1] == "." || int.TryParse(field[i + 1][j - 1], out tmp))
                            && (field[i][j - 1] == "." || int.TryParse(field[i][j - 1], out tmp))) continue;
                        var number = rowNumbers
                            .Where(tuple => tuple.Item2 == j - 1 || tuple.Item2 == j - 2).ToList();
                        if (number.Count is 0) continue;
                        sum += number
                            .Select(tuple => tuple.Item1).Sum(); ;
                        rowNumbers.Remove(number[0]);
                    }
                    else if (
                            (field[i + 1][j] != "." && !int.TryParse(field[i + 1][j], out tmp))
                            || (field[i + 1][j + 1] != "." && !int.TryParse(field[i + 1][j + 1], out tmp))
                            || (field[i][j + 1] != "." && !int.TryParse(field[i][j + 1], out tmp))
                            || (field[i][j - 1] != "." && !int.TryParse(field[i][j - 1], out tmp))
                            || (field[i + 1][j - 1] != "." && !int.TryParse(field[i + 1][j - 1], out tmp))
                        )
                    {
                        var number = rowNumbers
                            .Where(tuple => tuple.Item2 == j || tuple.Item2 == j - 1 || tuple.Item2 == j - 2).ToList();
                        if (number.Count is 0) continue;
                        sum += number
                            .Select(tuple => tuple.Item1).Sum(); ;
                        rowNumbers.Remove(number[0]);
                    }
                }
                else if (i == field.Length - 1)
                {
                    if (!int.TryParse(field[i][j], out var tmp))
                        continue;
                    if (j == 0)
                    {
                        if ((field[i - 1][j] == "." || int.TryParse(field[i - 1][j], out tmp))
                            && (field[i - 1][j + 1] == "." || int.TryParse(field[i - 1][j + 1], out tmp))
                            && (field[i][j + 1] == "." || int.TryParse(field[i][j + 1], out tmp))) continue;
                        sum += rowNumbers
                            .Select(tuple => tuple.Item1).Sum();
                        rowNumbers.Remove(rowNumbers[0]);
                    }
                    else if (j == field[i].Length-1)
                    {
                        if ((field[i - 1][j] == "." || int.TryParse(field[i - 1][j], out tmp))
                            && (field[i - 1][j - 1] == "." || int.TryParse(field[i - 1][j - 1], out tmp))
                            && (field[i][j - 1] == "." || int.TryParse(field[i][j - 1], out tmp))) continue;
                        var number = rowNumbers
                            .Where(tuple => tuple.Item2 == j - 1 || tuple.Item2 == j - 2).ToList();
                        if (number.Count is 0) continue;
                        sum += number
                            .Select(tuple => tuple.Item1).Sum(); ;
                        rowNumbers.Remove(number[0]);
                    }
                    else if (
                            (field[i][j + 1] != "." && !int.TryParse(field[i][j + 1], out tmp))
                            || (field[i - 1][j + 1] != "." && !int.TryParse(field[i - 1][j + 1], out tmp))
                            || (field[i - 1][j] != "." && !int.TryParse(field[i - 1][j], out tmp))
                            || (field[i - 1][j - 1] != "." && !int.TryParse(field[i - 1][j - 1], out tmp))
                            || (field[i][j - 1] != "." && !int.TryParse(field[i][j - 1], out tmp))
                            )
                    {
                        var number = rowNumbers
                            .Where(tuple => tuple.Item2 == j || tuple.Item2 == j - 1 || tuple.Item2 == j - 2).ToList();
                        if (number.Count is 0) continue;
                        sum += number
                            .Select(tuple => tuple.Item1).Sum(); ;
                        rowNumbers.Remove(number[0]);
                    }
                }
                else if (int.TryParse(field[i][j], out var tmp))
                {
                    if (j == 0)
                    {
                        if ((field[i + 1][j] == "." || int.TryParse(field[i + 1][j], out tmp))
                            && (field[i + 1][j + 1] == "." || int.TryParse(field[i + 1][j + 1], out tmp))
                            && (field[i][j + 1] == "." || int.TryParse(field[i][j + 1], out tmp))
                            && (field[i - 1][j + 1] == "." || int.TryParse(field[i - 1][j + 1], out tmp))
                            && (field[i - 1][j] == "." || int.TryParse(field[i - 1][j], out tmp))) continue;
                        sum += rowNumbers
                            .Select(tuple => tuple.Item1).Sum(); ;
                        rowNumbers.Remove(rowNumbers[0]);
                    }
                    else if (j == field[i].Length-1)
                    {
                        if ((field[i + 1][j] == "." || int.TryParse(field[i + 1][j], out tmp))
                            && (field[i + 1][j - 1] == "." || int.TryParse(field[i + 1][j - 1], out tmp))
                            && (field[i][j - 1] == "." || int.TryParse(field[i][j - 1], out tmp))
                            && (field[i - 1][j - 1] == "." || int.TryParse(field[i - 1][j - 1], out tmp))
                            && (field[i - 1][j] == "." || int.TryParse(field[i - 1][j], out tmp))) continue;
                        var number = rowNumbers
                            .Where(tuple => tuple.Item2 == j - 1 || tuple.Item2 == j - 2).ToList();
                        if (number.Count is 0) continue;
                        sum += number
                            .Select(tuple => tuple.Item1).Sum(); ;
                        rowNumbers.Remove(number[0]);
                    }
                    else if (
                        (field[i + 1][j] != "." && !int.TryParse(field[i + 1][j], out tmp))
                        || (field[i + 1][j + 1] != "." && !int.TryParse(field[i + 1][j + 1], out tmp))
                        || (field[i][j + 1] != "." && !int.TryParse(field[i][j + 1], out tmp))
                        || (field[i - 1][j + 1] != "." && !int.TryParse(field[i - 1][j + 1], out tmp))
                        || (field[i - 1][j] != "." && !int.TryParse(field[i - 1][j], out tmp))
                        || (field[i - 1][j - 1] != "." && !int.TryParse(field[i - 1][j - 1], out tmp))
                        || (field[i][j - 1] != "." && !int.TryParse(field[i][j - 1], out tmp))
                        || (field[i + 1][j - 1] != "." && !int.TryParse(field[i + 1][j - 1], out tmp))
                       )
                    {
                        var number = rowNumbers
                            .Where(tuple => tuple.Item2 == j || tuple.Item2 == j - 1 || tuple.Item2 == j - 2).ToList();
                        if (number.Count is 0) continue;
                        sum += number
                            .Select(tuple => tuple.Item1).Sum(); ;
                        rowNumbers.Remove(number[0]);
                    }
                }
            }
        }
        return sum;
    }
    private static IList<Tuple<int, int>> NumbersInRow(string s)
    {
        var matches = Regex.Matches(s, @"\d+").ToList();
        return matches.Select(match => new Tuple<int, int>(int.Parse(match.Value), match.Index)).ToList();
    }

    public static int SolveTask2(IEnumerable<string> dataEnumerable)
    {
        var data = dataEnumerable.ToArray();
        var allStars = AllStars(data);
        var allNumbers = AllNumbers(data);
        var sum = 0;

        foreach (var star in allStars)
        {
            var adjacentNumbers = allNumbers.Where(tuple =>
                    (tuple.Item2 == star.Item2 - 1 && tuple.Item3 == star.Item3 - 3) ||
                    (tuple.Item2 == star.Item2 - 1 && tuple.Item3 == star.Item3 - 2) ||
                    (tuple.Item2 == star.Item2 - 1 && tuple.Item3 == star.Item3 - 1) ||
                    (tuple.Item2 == star.Item2 - 1 && tuple.Item3 == star.Item3)     ||
                    (tuple.Item2 == star.Item2 - 1 && tuple.Item3 == star.Item3 + 1) ||
                    (tuple.Item2 == star.Item2     && tuple.Item3 == star.Item3 - 3) ||
                    (tuple.Item2 == star.Item2     && tuple.Item3 == star.Item3 - 2) ||
                    (tuple.Item2 == star.Item2     && tuple.Item3 == star.Item3 - 1) ||
                    (tuple.Item2 == star.Item2     && tuple.Item3 == star.Item3 + 1) ||
                    (tuple.Item2 == star.Item2 + 1 && tuple.Item3 == star.Item3 - 3) ||
                    (tuple.Item2 == star.Item2 + 1 && tuple.Item3 == star.Item3 - 2) ||
                    (tuple.Item2 == star.Item2 + 1 && tuple.Item3 == star.Item3 - 1) ||
                    (tuple.Item2 == star.Item2 + 1 && tuple.Item3 == star.Item3)     ||
                    (tuple.Item2 == star.Item2 + 1 && tuple.Item3 == star.Item3 + 1)
                    )
                .Select(tuple => tuple.Item1)
                .ToList();
            if (adjacentNumbers.Count is 2)
            {
                sum += adjacentNumbers.Aggregate((a, b) => a * b);
            }
        }
        return sum;
    }
    private static IList<Tuple<int, int, int>> AllNumbers(IEnumerable<string> rows)
    {
        var rowNumber = 0;
        var allNumbers = new List<Tuple<int, int, int>>();
        foreach (var row in rows)
        {
            var matches = Regex.Matches(row, @"\d+").ToList();
            allNumbers.AddRange(matches.Select(match => new Tuple<int, int, int>(int.Parse(match.Value), rowNumber, match.Index)).ToList());
            rowNumber++;
        }
        return allNumbers;
    }

    private static IList<Tuple<string, int, int>> AllStars(IEnumerable<string> lines)
    {
        var lineNumber = 0;
        var allNumbers = new List<Tuple<string, int, int>>();
        foreach (var line in lines)
        {
            var matches = Regex.Matches(line, @"\*").ToList();
            allNumbers.AddRange(matches.Select(match => new Tuple<string, int, int>(match.Value, lineNumber, match.Index)).ToList());
            lineNumber++;
        }
        return allNumbers;
    }
}
namespace AoC2023.AoC202301;

public static class Solver
{
    private static Tuple<int, int> IndexOfFirstDigit { get; set; } = new (int.MaxValue, 0);
    private static Tuple<int, int> IndexOfLastDigit { get; set; } = new (int.MinValue, 0);

    private static readonly string[] Patterns = new[]
    {
         "1", "2", "3", "4", "5", "6", "7", "8", "9",
         "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    public static int SolveTask1(IEnumerable<string> data)
    {
        var sum = 0;
        foreach (var s in data)
        {
            var number = string.Empty;
            foreach (var c in s)
            {
                if(c is >= '0' and <= '9' && number.Length is 0 or 1)
                        number += c;
                else if(c is > '/' and < ':' && number.Length == 2)
                        number = number.Remove(1) + c;
            }

            if (number.Length is 1)
            {
                number += number[0];
            }
            sum += int.Parse(number);
        }
        return sum;
    }

    public static int SolveTask2(IEnumerable<string> data)
    {

        var sum = 0;
        var results = new List<string>();
        foreach (var s in data)
        {
            var number = string.Empty;
            foreach (var pattern in Patterns)
            {
                s.Find(pattern);
            }
            
            number += IndexOfFirstDigit.Item2;
            number += IndexOfLastDigit.Item2;
            IndexOfFirstDigit = new Tuple<int, int>(int.MaxValue, 0);
            IndexOfLastDigit = new Tuple<int, int>(int.MinValue, 0);
            sum += int.Parse(number);
            results.Add(number);
        }

        foreach (var str in results)
        {
            Console.WriteLine(str);
        }

        return sum;
    }
    private static int ConvertWordToNumber(string word)
    {
        return word.ToLower() switch
        {
            "one" or "1" => 1,
            "two" or "2" => 2,
            "three" or "3" => 3,
            "four" or "4" => 4,
            "five" or "5" => 5,
            "six" or "6" => 6,
            "seven" or "7" => 7,
            "eight" or "8" => 8,
            "nine" or "9" => 9
        };
    }


    private static void Find(this string src, string input)
    {
        var firstIndex = src.IndexOf(input, StringComparison.CurrentCultureIgnoreCase);
        while(firstIndex != -1){

            if (firstIndex < IndexOfFirstDigit.Item1)
            {
                IndexOfFirstDigit = new Tuple<int, int>(firstIndex, ConvertWordToNumber(input));
            }
            if (firstIndex > IndexOfLastDigit.Item1)
            {
                IndexOfLastDigit = new Tuple<int, int>(firstIndex, ConvertWordToNumber(input));
            }

            firstIndex = src.IndexOf(input, firstIndex + 1, StringComparison.CurrentCultureIgnoreCase);
        }
    }
}